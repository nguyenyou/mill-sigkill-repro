package generated

final case class Data74(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data74 = copy(name = name.toUpperCase)
  def scale(k: Double): Data74 = copy(value = value * k)
  def addTag(t: String): Data74 = copy(tags = t :: tags)
  def put(k: String, v: String): Data74 = copy(meta = meta.updated(k, v))
  def merge(other: Data74): Data74 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data74 {
  given Ordering[Data74] = Ordering.by(_.id)
  def empty: Data74 = Data74(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data74 =
    Data74(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data74] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
