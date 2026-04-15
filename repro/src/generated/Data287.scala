package generated

final case class Data287(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data287 = copy(name = name.toUpperCase)
  def scale(k: Double): Data287 = copy(value = value * k)
  def addTag(t: String): Data287 = copy(tags = t :: tags)
  def put(k: String, v: String): Data287 = copy(meta = meta.updated(k, v))
  def merge(other: Data287): Data287 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data287 {
  given Ordering[Data287] = Ordering.by(_.id)
  def empty: Data287 = Data287(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data287 =
    Data287(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data287] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
