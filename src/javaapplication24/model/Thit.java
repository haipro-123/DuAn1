/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class Thit{
    private String Id;
    private String Ten;
    private String Mota;

    public Thit() {
    }

    public Thit(String Id, String Ten, String Mota) {
        this.Id = Id;
        this.Ten = Ten;
        this.Mota = Mota;
    }

    public Thit(String Ten, String Mota) {
        this.Ten = Ten;
        this.Mota = Mota;
    }
    
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    @Override
    public String toString() {
        return Ten;
    }
    
    
}
