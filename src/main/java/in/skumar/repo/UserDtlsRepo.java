package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skumar.entity.UserDtlsEntity;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {

}
