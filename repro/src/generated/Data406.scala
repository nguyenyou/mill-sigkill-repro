package generated

final case class Data406(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data406 = copy(name = name.toUpperCase)
  def scale(k: Double): Data406 = copy(value = value * k)
  def addTag(t: String): Data406 = copy(tags = t :: tags)
  def put(k: String, v: String): Data406 = copy(meta = meta.updated(k, v))
  def merge(other: Data406): Data406 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data406 {
  given Ordering[Data406] = Ordering.by(_.id)
  def empty: Data406 = Data406(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data406 =
    Data406(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data406] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
