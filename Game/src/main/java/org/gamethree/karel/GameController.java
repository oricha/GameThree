
package org.gamethree.karel;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class GameController {
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	final static int[] divArray = new int[]{0,-1, 1};
	@Value("${random.max.value:1000}")
	private final static int MAX = 100;
	private Player player1;

	@RequestMapping(value = {"", "/", "start"}, method = RequestMethod.GET)
	public String start(Model model) {
		
		this.player1 = new Player(ThreadLocalRandom.current().nextInt(10),
								ThreadLocalRandom.current().nextInt(MAX));
		model.addAttribute("player", this.player1);
		log.info("New player "+ player1.getId());
		return "home";
	}

	@RequestMapping(value = "/getplayer", method = RequestMethod.GET)
	public @ResponseBody Player getplayer(@ModelAttribute Player _player, Model model) {
		log.info("init getplayer - Retrieving player "+ player1.getId());
		if (player1 == null){
			new NotFoundException("Something is wrong.Player Not found");
		}	
		return player1;
	}
	
	@RequestMapping(value = "/move/{number}", method = RequestMethod.GET)
	public @ResponseBody Player move( @PathVariable int number, Model model) {
		log.info("init getplayer - Retrieving "+number);
		//Random sum / 3
		if (player1 == null){
			new NotFoundException("Something wrong dute");
		}	
		player1.setNumber((number+ divArray[(number % 3)]) / 3);
		
		log.info("Player 1 move Id:" + player1.getId() + " Number : "+ player1.getNumber());
		model.addAttribute("player", player1);
		if( player1.getNumber() == 1){
			return player1;
		}
		return player1;
	}
}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
class NotFoundException extends Exception {

	private static final long serialVersionUID = -8799592952743110703L;

	public NotFoundException(String msg) {
		super(msg);
	}
}
