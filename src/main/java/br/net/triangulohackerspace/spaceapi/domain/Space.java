package br.net.triangulohackerspace.spaceapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Space extends AbstractDomain implements Serializable {

	private static final long serialVersionUID = 8883842678258104959L;

	@NotNull
	@Size(max = 64)
	@Column(name = "api_version", nullable = false)
	private String apiVersion;

	@NotNull
	@Size(max = 64)
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Size(max = 64)
	@Column(name = "logo", nullable = false)
	private String logo;

	@NotNull
	@Size(max = 64)
	@Column(name = "url", nullable = false)
	private String url;

/*	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Location> location = new LinkedList<Location>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Spacefed> spacefeds = new LinkedList<Spacefed>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contact> contacts = new LinkedList<Contact>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<IssueReportChannels> issueReportChannels = new LinkedList<IssueReportChannels>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<State> states = new LinkedList<State>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Project> projects = new LinkedList<Project>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Cache> caches = new LinkedList<Cache>();

	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sensor> sensors = new LinkedList<Sensor>();*/

	public Space() {
		super();
	}

	public Space(Long id) {
		super(id);
	}

	// [TODO] passar para build
	public Space(Long id, String apiVersion, String name, String logo, String url) {
		super(id);
		this.apiVersion = apiVersion;
		this.name = name;
		this.logo = logo;
		this.url = url;

	}

	
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apiVersion == null) ? 0 : apiVersion.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Space other = (Space) obj;
		if (apiVersion == null) {
			if (other.apiVersion != null)
				return false;
		} else if (!apiVersion.equals(other.apiVersion))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Space [apiVersion=" + apiVersion + ", name=" + name + ", logo="
				+ logo + ", url=" + url + "]";
	}

}
