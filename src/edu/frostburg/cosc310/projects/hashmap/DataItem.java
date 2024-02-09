package edu.frostburg.cosc310.projects.hashmap;

//data item
public class DataItem {
	//public String abilities;
	public String attack;
	public String classfication;
	public String defense;
	public String hp;
	public String japanese_name;
	public String name;//data item (key)
	public String pokedex_number;
	public String sp_attack;
	public String sp_defense;
	public String speed;
	public String type1;
	public String type2;
	
	public DataItem(String attack,String classfication,String defense,String hp,String japanese_name,String name,String pokedex_number,String sp_attack,String sp_defense,String speed,String type1,String type2) {
		//this.abilities = abilities;
		this.attack = attack;
		this.classfication = classfication;
		this.defense = defense;
		this.hp=hp;
		this.japanese_name = japanese_name;
		this.name = name;
		this.pokedex_number = pokedex_number;
		this.sp_attack = sp_attack;
		this.sp_defense = sp_defense;
		this.speed = speed;
		this.type1 = type1;
		this.type2 = type2;
	}

//	public String getAbilities() {
//		return abilities;
//	}
	public String getAttack() {
		return attack;
	}
	public String getClassfication() {
		return classfication;
	}
	public String getDefense() {
		return defense;
	}
	public String getHp() {
		return hp;
	}
	public String getJapanese_name() {
		return japanese_name;
	}
	public String getName() {
		return name;
	}
	public String getPokedex_number() {
		return pokedex_number;
	}
	public String getSp_attack() {
		return sp_attack;
	}
	public String getSp_defense() {
		return sp_defense;
	}
	public String getSpeed() {
		return speed;
	}
	public String getType1() {
		return type1;
	}
	public String getType2() {
		return type2;
	}
	
	@Override
	public String toString() {
		return "DataItem [attack=" + attack + ", classfication=" + classfication + ", defense=" + defense + ", hp=" + hp
				+ ", japanese_name=" + japanese_name + ", name=" + name + ", pokedex_number=" + pokedex_number
				+ ", sp_attack=" + sp_attack + ", sp_defense=" + sp_defense + ", speed=" + speed + ", type1=" + type1
				+ ", type2=" + type2 + "]";
	}
}