package generate;

import generate.ExportTask;

/**
 * @Entity generate.ExportTask
 */
public interface ExportTaskDao {
    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long exportTaskId);

    /**
     * @mbg.generated
     */
    int insert(ExportTask record);

    /**
     * @mbg.generated
     */
    int insertSelective(ExportTask record);

    /**
     * @mbg.generated
     */
    ExportTask selectByPrimaryKey(Long exportTaskId);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ExportTask record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(ExportTask record);
}