/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.QLNhanVien;
import java.util.List;

/**
 *
 * @author Do Quoc Thinh
 */
public interface INhanVienService {

    List<QLNhanVien> getAllNhanVien();

    QLNhanVien addNhanVien(QLNhanVien nv);

    QLNhanVien updateNhanVienById(QLNhanVien nv);

    int deleteNhanVienById(String id);
    
    
    
}
