package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienRepository nhanvienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanvienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(Long id) {
        return nhanvienRepository.findById(id);
    }

    public NhanVien addNhanVien(NhanVien nhanVien) {
        return nhanvienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanvienRepository.findById(nhanVien.getId())
                .orElseThrow(() -> new IllegalStateException("Nhan vien with ID " +
                        nhanVien.getId() + " does not exist."));
        existingNhanVien.setManv(nhanVien.getManv());
        existingNhanVien.setName(nhanVien.getName());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setNoisinh(nhanVien.getNoisinh());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());
        return nhanvienRepository.save( existingNhanVien);
    }

    public void deleteNhanVienById(Long id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Nhan vien with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }


}
