public class TestEquals {
		private String name;
		public TestEquals(String name) { this.name = name; }
		public boolean equals(TestEquals p) {
			return p.name.equals(this.name);
		}
}