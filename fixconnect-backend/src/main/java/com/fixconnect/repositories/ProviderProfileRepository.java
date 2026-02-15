package com.fixconnect.repositories;

import com.fixconnect.entities.ProviderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderProfileRepository extends JpaRepository<ProviderProfile,String> {
}
