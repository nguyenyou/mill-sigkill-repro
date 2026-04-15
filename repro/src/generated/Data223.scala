package generated

final case class Data223(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data223 = copy(name = name.toUpperCase)
  def scale(k: Double): Data223 = copy(value = value * k)
  def addTag(t: String): Data223 = copy(tags = t :: tags)
  def put(k: String, v: String): Data223 = copy(meta = meta.updated(k, v))
  def merge(other: Data223): Data223 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data223 {
  given Ordering[Data223] = Ordering.by(_.id)
  def empty: Data223 = Data223(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data223 =
    Data223(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data223] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
