package service;

import domain.Hardware;
import repository.CrRepository;

public class HardwareService {
    private CrRepository<Hardware, Integer> repository;

    public HardwareService() {
        this.repository = new CrRepository<>(Hardware.class);
    }

    public Hardware getById(Integer id) { return repository.getById(id); }

    public void save(Hardware hardware) { repository.save(hardware); }
}
