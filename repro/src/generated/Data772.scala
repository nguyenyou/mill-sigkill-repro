package generated

final case class Data772(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data772 = copy(name = name.toUpperCase)
  def scale(k: Double): Data772 = copy(value = value * k)
  def addTag(t: String): Data772 = copy(tags = t :: tags)
  def put(k: String, v: String): Data772 = copy(meta = meta.updated(k, v))
  def merge(other: Data772): Data772 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data772 {
  given Ordering[Data772] = Ordering.by(_.id)
  def empty: Data772 = Data772(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data772 =
    Data772(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data772] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
