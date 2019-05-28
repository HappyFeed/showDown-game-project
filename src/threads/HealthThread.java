package threads;

import javafx.scene.shape.Rectangle;
import model.Pokemon;
import ui.MatchController;

public class HealthThread extends Thread{

	private Rectangle r;
	private Pokemon enemyPokemon;
	private Pokemon teamPokemon;
	private int power;
	private double health;
	private String kindSkill;
	private MatchController mc;
	
	public HealthThread(Rectangle r, Pokemon enemyPokemon,Pokemon teamPokemon, int power, double health,String kindSkill,MatchController mc) {
		this.r = r;
		this.enemyPokemon = enemyPokemon;
		this.teamPokemon = teamPokemon;
		this.power = power;
		this.health = health;
		this.kindSkill = kindSkill;
		this.mc=mc;
	}
	
	public void run() {
		try {
			 double damage=0;
			 double life=0;
			 double indiceV=0;
			 double rec=0;
			 
		    if(kindSkill.equals("Damage")) {
			    damage=(teamPokemon.getBasicAtack()+power)-(enemyPokemon.getBasicDefense());
			    life=enemyPokemon.getBaseLife()-damage;
			    indiceV=1-(life/enemyPokemon.getBaseLife());
			    rec=r.getWidth()-(r.getWidth()*indiceV);
			    enemyPokemon.setBaseLife(life);
				mc.setFillRed();
				sleep(500);			
				mc.setWeight(rec);
				mc.setFillGreen();
			}else if(kindSkill.equals("Defense")){
				damage=teamPokemon.getBasicDefense()+power;
				teamPokemon.setBasicDefense(damage);
				mc.setFillBlue();
				sleep(500);
				mc.setFillGreenA();
			}else if(kindSkill.equals("Health")){
				 if(r.getWidth()<170){
					damage=teamPokemon.getBaseLife()+(teamPokemon.getBaseLife()*health);
					indiceV=1-(life/enemyPokemon.getBaseLife());
					rec=r.getWidth()+(r.getWidth()*indiceV);
					if(rec>170) {
						rec=rec-(rec-170);
					}
					teamPokemon.setBaseLife(damage);
					mc.setFillPink();
					sleep(500);
					mc.setWeight(rec);
					mc.setFillGreenA();
				}
				

			}

		   
		}catch (InterruptedException e) {

				e.printStackTrace();
		}
	}
	
}
