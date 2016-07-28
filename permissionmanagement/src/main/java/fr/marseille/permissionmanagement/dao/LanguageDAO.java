package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Language;

// TODO: Auto-generated Javadoc
/**
 * The Interface LanguageDAO.
 */
public interface LanguageDAO {

    /**
     * Save.
     *
     * @param language the language
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(Language language) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Language> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the language
     * @throws DAOException the DAO exception
     */
    public Language find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param language the language
     * @return the language
     * @throws DAOException the DAO exception
     */
    public Language update(Language language) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

    /**
     * Find default languages.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Language> findDefaultLanguages() throws DAOException;

}