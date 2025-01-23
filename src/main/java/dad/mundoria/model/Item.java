package dad.mundoria.model;

public class Item {
	
	public enum TipoItem {
		
		ARMADURA("Este item es equipable como armadura, te modificará las estadísticas"),
		ARMA("Este item es equipable como armadura, te modificará las estadísticas"),
		CONSUMIBLE("Este item es consumible, al usarlo desaparecerá y te modificará las estadísticas de manera temporal o permanente"),
		MISION("Este es un item únicamente util para una misión concreta, ten cuidado");
		
		private String descripcion;
		
		TipoItem(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public String getDescripcion() {
			return descripcion;
		}
	}
	
	public enum RarezaItem {
		
		COMUN("Un item bastante común"),
		RARO("Algo que no se consigue tan facilmente como lo demás"),
		BUENO("Item de buena calidad, con un valor y utildiad acorde"),
		EXCEPCIONAL("Algo que no se ve todos los días, es de muy buena calidad"),
		LEGENDARIO("Item súmamente complicado de conseguir, es de lo mejor que te puedes encontrar");
		
		private String descripcion;
		
		RarezaItem(String descripcion) {
			this.descripcion = descripcion;				
		}
		
		public String getDescripcion() {
			return descripcion;
		}
		
	}
	
	private int idItem;
	private String nombre;
	private String descripcion;
	private int saludExtra;
	private int stamanaExtra;
	private int agilidadExtra;
	private int suerteExtra;
	private int defensaExtra;
	private int ataqueExtra;
	private double valor;
	private boolean estaEquipado;
	private TipoItem tipo;
	private RarezaItem rareza;
	
	public Item(int idItem, String nombre, String descripcion, int saludExtra, int stamanaExtra, int agilidadExtra,
			int suerteExtra, int defensaExtra, int ataqueExtra, double valor, boolean estaEquipado, TipoItem tipo, RarezaItem rareza) {
		super();
		this.idItem = idItem;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.saludExtra = saludExtra;
		this.stamanaExtra = stamanaExtra;
		this.agilidadExtra = agilidadExtra;
		this.suerteExtra = suerteExtra;
		this.defensaExtra = defensaExtra;
		this.ataqueExtra = ataqueExtra;
		this.valor = valor;
		this.estaEquipado = estaEquipado;
		this.tipo = tipo;
		this.rareza = rareza;
	}
	//TODO Desarrollar bien el sistema de equipar y desequipar items, probablemente haya que mover esto a Inventario.
	public void equipar() {
		estaEquipado = true;
		
	}
	
	public void desequipar() {
		estaEquipado = false;
	}

	public int getIdItem() {
		return idItem;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getSaludExtra() {
		return saludExtra;
	}

	public int getStamanaExtra() {
		return stamanaExtra;
	}

	public int getAgilidadExtra() {
		return agilidadExtra;
	}

	public int getSuerteExtra() {
		return suerteExtra;
	}

	public int getDefensaExtra() {
		return defensaExtra;
	}

	public int getAtaqueExtra() {
		return ataqueExtra;
	}

	public double getValor() {
		return valor;
	}

	public boolean isEstaEquipado() {
		return estaEquipado;
	}

	public TipoItem getTipo() {
		return tipo;
	}
	
	public RarezaItem getRareza() {
		return rareza;
	}
	
	
	
	
	
}
