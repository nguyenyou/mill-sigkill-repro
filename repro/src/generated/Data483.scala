package generated

final case class Data483(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data483 = copy(name = name.toUpperCase)
  def scale(k: Double): Data483 = copy(value = value * k)
  def addTag(t: String): Data483 = copy(tags = t :: tags)
  def put(k: String, v: String): Data483 = copy(meta = meta.updated(k, v))
  def merge(other: Data483): Data483 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data483 {
  given Ordering[Data483] = Ordering.by(_.id)
  def empty: Data483 = Data483(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data483 =
    Data483(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data483] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
