/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import java.util.List;
import javaapplication24.model.Voucher;

/**
 *
 * @author Admin
 */
public interface VoucherService {

    public List<Voucher> getList();

    public boolean add(Voucher vou);

    public boolean update(Voucher vou);
    
}
