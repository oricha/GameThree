
package org.takeaway.karel;

import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class GameController extends WebMvcConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	final static int[] divArray = new int[] { 0, -1, 1 };
	private Player player2;
	private static String PORT = "8080";

	@RequestMapping(value = { "", "/", "start" }, method = RequestMethod.GET)
	public String start(Model model) throws NotFoundException {

		this.player2 = new Player(ThreadLocalRandom.current().nextInt(10), 0);
		RestTemplate restTemplate = new RestTemplate();
		Player player1 = restTemplate.getForObject("http://localhost:" + PORT + "/getplayer", Player.class);
		if (player1 == null) {
			throw new NotFoundException("Something is wrong. Does the game has started?");
		}
		player2.setNumber(player1.getNumber());
		model.addAttribute("player", this.player2);
		return "home";
	}

	@RequestMapping(value = "/getplayer", method = RequestMethod.GET)
	public @ResponseBody Player getPlayer(@ModelAttribute Player player, Model model) throws NotFoundException {
		if (player2 == null) {
			new NotFoundException("Something is wrong. Player Not Found");
		}
		return player2;
	}

	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public String move(@Valid Player _player, BindingResult bdResult, Model model) {
		if (bdResult.hasErrors()) {
			model.addAttribute("player", _player);
			return "home";
		}
		if (_player.isAutomatic()) {
			player2.setNumber((_player.getNumber() + divArray[(_player.getNumber() % 3)])/ 3);
		} else {
			player2.setNumber((_player.getNumber() + _player.getSum()) / 3);
		}

		if (player2.getNumber() == 1) {
			model.addAttribute("player", player2);
			model.addAttribute("message", "I Win ");
			return "result";
		}

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:" + PORT + "/move/{number}";
		Player player1 = restTemplate.getForObject(uri, Player.class, player2.getNumber());
		player2.setNumber(player1.getNumber());
		model.addAttribute("player", player2);

		if (player1.getNumber() == 1) {
			log.info("He won");
			model.addAttribute("message", "They Win ");
			return "result";
		}
		return "home";
	}
}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
class NotFoundException extends Exception {

	private static final long serialVersionUID = -8799592952743110703L;

	public NotFoundException(String msg) {
		super(msg);
	}
}
