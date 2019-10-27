package no.hvl.dat108;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(schema = "handleliste", name = "handleliste")
public class Liste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private List<Vare> handleliste = new ArrayList<>();
    
    public Liste() {
    	
    }

    public Vare getVare(int index) {
        return handleliste.get(index);
    }
    
    public void addVare(Vare vare) {
        this.handleliste.add(vare);
    }
    
    public void deleteVare(int index) {
    	this.handleliste.remove(index);
    }
    
    public List<Vare> getListe() {
        return handleliste;
    }
	
	public int indexOf(Vare v) {
		return handleliste.indexOf(v);
	}
	
	
}