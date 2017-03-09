package jp.co.tad.mybatis.mapper;

import java.util.List;
import java.util.Map;

import jp.co.tad.Entity.ShainEntity;

/***
 * 社員テーブルMapperインターフェース
 * @author watanabek
 */
public interface SqlShainMapper {
	public List<ShainEntity> selectAll();
	public int existShain(Map<String, Object> param);
	public int insertShain(ShainEntity entity);
	public ShainEntity getShainByKey(String shainId);
	public int updateShain(ShainEntity entity);
}
