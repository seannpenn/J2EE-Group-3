package Group3.Group3prelims.FileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group3.Group3prelims.FileUpload.entity.File;


@Repository
public interface IFileRepository extends JpaRepository<File, Integer> {

}
