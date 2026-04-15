package generated

final case class Data283(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data283 = copy(name = name.toUpperCase)
  def scale(k: Double): Data283 = copy(value = value * k)
  def addTag(t: String): Data283 = copy(tags = t :: tags)
  def put(k: String, v: String): Data283 = copy(meta = meta.updated(k, v))
  def merge(other: Data283): Data283 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data283 {
  given Ordering[Data283] = Ordering.by(_.id)
  def empty: Data283 = Data283(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data283 =
    Data283(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data283] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
