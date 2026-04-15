package generated

final case class Data835(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data835 = copy(name = name.toUpperCase)
  def scale(k: Double): Data835 = copy(value = value * k)
  def addTag(t: String): Data835 = copy(tags = t :: tags)
  def put(k: String, v: String): Data835 = copy(meta = meta.updated(k, v))
  def merge(other: Data835): Data835 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data835 {
  given Ordering[Data835] = Ordering.by(_.id)
  def empty: Data835 = Data835(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data835 =
    Data835(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data835] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
