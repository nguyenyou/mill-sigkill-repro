package generated

final case class Data773(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data773 = copy(name = name.toUpperCase)
  def scale(k: Double): Data773 = copy(value = value * k)
  def addTag(t: String): Data773 = copy(tags = t :: tags)
  def put(k: String, v: String): Data773 = copy(meta = meta.updated(k, v))
  def merge(other: Data773): Data773 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data773 {
  given Ordering[Data773] = Ordering.by(_.id)
  def empty: Data773 = Data773(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data773 =
    Data773(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data773] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
