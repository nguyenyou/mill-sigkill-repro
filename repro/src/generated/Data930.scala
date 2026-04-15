package generated

final case class Data930(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data930 = copy(name = name.toUpperCase)
  def scale(k: Double): Data930 = copy(value = value * k)
  def addTag(t: String): Data930 = copy(tags = t :: tags)
  def put(k: String, v: String): Data930 = copy(meta = meta.updated(k, v))
  def merge(other: Data930): Data930 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data930 {
  given Ordering[Data930] = Ordering.by(_.id)
  def empty: Data930 = Data930(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data930 =
    Data930(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data930] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
