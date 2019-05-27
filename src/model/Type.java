package model;

public enum Type {
	Normal,Fire,Water,Electric,Grass,Ice,Fighting,
	 Poison,Ground,Flying,Psychic,Bug,Rock,Ghost,
	 Dragon,Dark,Steel,Fairy;
	 
	public Type assigType(int n) {
		Type p=null;
		if(n==1) {
			p= Fire;
		}else if(n==2) {
			p= Normal;
		}else if(n==3) {
			p= Water;
		}else if(n==4) {
			p= Electric;
		}else if(n==5) {
			p= Grass;
		}else if(n==6) {
			p= Ice;
		}else if(n==7) {
			p= Fighting;
		}else if(n==8) {
			p= Poison;
		}else if(n==9) {
			p= Ground;
		}else if(n==10) {
			p= Flying;
		}else if(n==11) {
			p= Psychic;
		}else if(n==12) {
			p= Bug;
		}else if(n==13) {
			p= Rock;
		}else if(n==14) {
			p= Ghost;
		}else if(n==15) {
			p= Dragon;
		}else if(n==16) {
			p= Dark;
		}else if(n==17) {
			p= Steel;
		}else if(n==18) {
			p= Fairy;
		}
		return p;
	}
}
