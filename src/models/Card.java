package models;

import javax.swing.ImageIcon;
import javax.swing.JButton;
@SuppressWarnings("serial")

public class Card extends JButton {
	//INSTANCE VARIABLES
	private ImageIcon _url;
	private String _s;
	private boolean _face;
	
	//CONSTRUCTOR
	public Card(String u) {
		_url = new ImageIcon(getClass().getResource(u));
		_face = false;
		_s = u;
	}
	
	//GETTERS
	public String getSource() {
		return _s;
	}
	public boolean getFace() {
		return _face;
	}
	public ImageIcon getPic() {
		return _url;
	}
	
	//SETTERS
	public void setUrl(String s) {
		this._url = new ImageIcon(getClass().getResource(s));
	}
	public void setFace(boolean b) {
		this._face = b;
	}
}
