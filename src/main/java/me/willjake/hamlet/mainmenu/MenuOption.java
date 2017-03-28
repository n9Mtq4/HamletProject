package me.willjake.hamlet.mainmenu;

/**
 * Created by will on 3/28/17 at 2:51 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public abstract class MenuOption {
	
	private String choiceOption;
	
	public MenuOption(String choiceOption) {
		this.choiceOption = choiceOption;
	}
	
	public abstract void callback();
	
	public String getChoiceOption() {
		return choiceOption;
	}
	
	public void setChoiceOption(String choiceOption) {
		this.choiceOption = choiceOption;
	}
	
}
