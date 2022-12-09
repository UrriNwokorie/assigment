module user {
	private Integer id;
	  private String name;
	  private String email;
	  // setters & getters
	  public Integer getId() {
	      return id;
	  }
	  public void setId(Integer id) {
	      this.id = id;
	  }
	  public String getName() {
	      return name;
	  }
	  public void setName(String name) {
	      this.name = name;
	  }
	  public String getEmail() {
	      return email;
	  }
	  public void setEmail(String email) {
	      this.email = email;
	  }
	}
	@Repository
	public class UserRepository
	{
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  @Transactional(readOnly=true)
	  public List<User> findAll() {
	      return jdbcTemplate.query("select id, name, email from users", new UserRowMapper());
	  }
	}
	class UserRowMapper implements RowMapper<User>
	{
	  @Override
	  public User mapRow(ResultSet rs, int rowNum) throws SQLException
	  {
	      User user = new User();
	      user.setId(rs.getInt("id"));
	      user.setName(rs.getString("name"));
	      user.setEmail(rs.getString("email"));
	      return user;
	  }
	}
	@SpringBootTest
	public class UserRepositoryTests {
	   @Autowired
	   private UserRepository userRepository;
	   @Test
	   public void testFindAll() {
	       List<User> users = userRepository.findAll();
	       assertThat(users).isNotEmpty();
	       User user = users.get(0);
	       assertThat(user.getId()).isEqualTo(1);
	       assertThat(user.getName()).isEqualTo("John Doe");
	      &..n@example.com");
	   }
	}
}