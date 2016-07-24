package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Language;

public interface LanguageDAO {

    public boolean save(Language language) throws DAOException;

    public List<Language> findAll() throws DAOException;

    public Language find(Integer id) throws DAOException;

    public Language update(Language language) throws DAOException;

    public boolean delete(Integer id) throws DAOException;

}