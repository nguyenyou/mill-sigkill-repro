package generated

final case class Data750(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data750 = copy(name = name.toUpperCase)
  def scale(k: Double): Data750 = copy(value = value * k)
  def addTag(t: String): Data750 = copy(tags = t :: tags)
  def put(k: String, v: String): Data750 = copy(meta = meta.updated(k, v))
  def merge(other: Data750): Data750 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data750 {
  given Ordering[Data750] = Ordering.by(_.id)
  def empty: Data750 = Data750(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data750 =
    Data750(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data750] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
