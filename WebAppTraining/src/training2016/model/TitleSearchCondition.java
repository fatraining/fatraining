package training2016.model;

import org.apache.commons.lang3.StringUtils;

import training2016.annotations.SimpleCondition;
import training2016.annotations.ToInteger;
import training2016.annotations.ToString;

public class TitleSearchCondition extends AbstractSearchCondition {

	@ToInteger
	@SimpleCondition(name="id", operator="=")
	private String id;

	@ToString
	@SimpleCondition(name="name", operator="=")
	private String name;

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
	 * @return idがあるか
	 */
	private boolean hasId() {
		return StringUtils.isNotEmpty(this.id);
	}

	/**
	 * @return nameがあるか
	 */
	private boolean hasName() {
		return StringUtils.isNotEmpty(this.name);
	}

	/**
	 * コンストラクタ
	 */
	public TitleSearchCondition() {
		super(Title.class);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean hasCondition() {
		// TODO 自動生成されたメソッド・スタブ
		return this.hasId() || this.hasName();
	}

}
