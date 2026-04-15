package generated

final case class Data292(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data292 = copy(name = name.toUpperCase)
  def scale(k: Double): Data292 = copy(value = value * k)
  def addTag(t: String): Data292 = copy(tags = t :: tags)
  def put(k: String, v: String): Data292 = copy(meta = meta.updated(k, v))
  def merge(other: Data292): Data292 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data292 {
  given Ordering[Data292] = Ordering.by(_.id)
  def empty: Data292 = Data292(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data292 =
    Data292(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data292] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
