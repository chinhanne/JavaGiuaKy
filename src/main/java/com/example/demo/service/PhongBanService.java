package com.example.demo.service;

import com.example.demo.model.PhongBan;
import com.example.demo.repository.PhongBanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public Optional<PhongBan> getPhongBanById(Long id) {
        return phongBanRepository.findById(id);
    }

    public void addPhongBan(PhongBan phongban) {
        phongBanRepository.save(phongban);
    }

    public void updatePhongBan(@NotNull PhongBan phongban) {
        PhongBan existingPhongBan = phongBanRepository.findById(phongban.getId())
                .orElseThrow(() -> new IllegalStateException("Phong ban with ID " +
                        phongban.getId() + " does not exist."));
        existingPhongBan.setMaPhong(phongban.getMaPhong());
        existingPhongBan.setTenPhong(phongban.getTenPhong());
        phongBanRepository.save(existingPhongBan);
    }
    public void deletePhongBanById(Long id) {
        if (!phongBanRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does no exist.");
        }
        phongBanRepository.deleteById(id);
    }
}
