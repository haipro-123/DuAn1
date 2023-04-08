/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class ThitViewModel {
    private int Stt;
    private String Ma;
    private String Ten;
    private String Mota;

    public ThitViewModel() {
    }

    public ThitViewModel(int Stt, String Ma, String Ten, String Mota) {
        this.Stt = Stt;
        this.Ma = Ma;
        this.Ten = Ten;
        this.Mota = Mota;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
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
