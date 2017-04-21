package training2016.model;

import org.apache.commons.lang3.StringUtils;

import training2016.annotations.ArrayCondition;
import training2016.annotations.SimpleCondition;
import training2016.annotations.ToInteger;
import training2016.annotations.ToString;

public class CopySearchCondition extends AbstractSearchCondition {

	@ToInteger
	@SimpleCondition(name="id", operator="=")
	private String id;

	@ToInteger
	@ArrayCondition(name="id", operator="=")
	private String[] ids;

	@ToString
	@SimpleCondition(name="name", fuzzy=true, operator="like")
	private String name;

	@ToInteger
	@SimpleCondition(name="title_id", operator="=")
	private String title_id;

	@ToInteger
	@SimpleCondition(name="delete_flag", operator="=")
	private String delete_flag;



	/**
	 * @return delete_flag
	 */
	public String getDeleteFlag() {
		return this.delete_flag;
	}

	/**
	 * @param delete_Flag
	 */
	public void setDeleteFlag(String delete_Flag) {
		this.delete_flag = delete_Flag;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return ids
	 */
	public String[] getIds() {
		return this.ids;
	}

	/**
	 * @param ids
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return title_id
	 */
	public String getTitleid() {
		return this.title_id;
	}

	/**
	 * @param titleid
	 */
	public void setTitleid(String titleid) {
		this.title_id = titleid;
	}

	/**
	 *コンストラクタ
	 */
	public CopySearchCondition() {
		super(Copy.class);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * SQLの条件追加
	 */
	@Override
	protected String generateTableName() {
		return modelClass.getName() + " as " + modelClass.getSimpleName().toLowerCase() + " left join fetch copy.title";
	}

	/**
	 * @return IDがあるかどうか
	 */
	private boolean hasId() {
		return StringUtils.isNotEmpty(this.id);
	}

	/**
	 * @return idsがあるかどうか
	 */
	private boolean hasIds() {
		return this.ids != null && this.ids.length > 0;
	}

	/**
	 * @return nameがあるかどうか
	 */
	private boolean hasName() {
		return StringUtils.isNotEmpty(this.name);
	}

	/**
	 * @return title_idがあるかどうか
	 */
	private boolean hasTitleId() {
		return this.title_id != null;
	}

	/**
	 * @return delete_flagがあるかどうか
	 */
	private boolean hasDeleteFlag(){
		return StringUtils.isNotEmpty(this.delete_flag);
	}

	@Override
	public boolean hasCondition() {
		// TODO 自動生成されたメソッド・スタブ
		return this.hasId() || this.hasIds() || this.hasName() || this.hasTitleId()||this.hasDeleteFlag();
	}

}
