/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.model.Voucher;
import javaapplication24.repository.VoucherRepository;
import javaapplication24.service.VoucherService;

/**
 *
 * @author Admin
 */
public class VoucherServiceImpl implements VoucherService{
    VoucherRepository vr = new VoucherRepository();
    @Override
    public List<Voucher> getList() {
        return vr.getList();
    }

    @Override
    public boolean add(Voucher vou) {
        return vr.add(vou);
    }

    @Override
    public boolean update(Voucher vou) {
        return vr.update(vou);
    }
    
}
