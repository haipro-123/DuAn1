/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.Thit;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InThitRes {
    ArrayList<Thit> read();
    Thit getThitByMa(String Ma);
    Thit getThitByTen(String Ten);
    int add(Thit t);
    int delete(String Ma);
    int update(Thit t);
}
