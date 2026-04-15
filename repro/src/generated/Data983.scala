package generated

final case class Data983(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data983 = copy(name = name.toUpperCase)
  def scale(k: Double): Data983 = copy(value = value * k)
  def addTag(t: String): Data983 = copy(tags = t :: tags)
  def put(k: String, v: String): Data983 = copy(meta = meta.updated(k, v))
  def merge(other: Data983): Data983 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data983 {
  given Ordering[Data983] = Ordering.by(_.id)
  def empty: Data983 = Data983(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data983 =
    Data983(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data983] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
