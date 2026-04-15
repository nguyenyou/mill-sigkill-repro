package generated

final case class Data361(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data361 = copy(name = name.toUpperCase)
  def scale(k: Double): Data361 = copy(value = value * k)
  def addTag(t: String): Data361 = copy(tags = t :: tags)
  def put(k: String, v: String): Data361 = copy(meta = meta.updated(k, v))
  def merge(other: Data361): Data361 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data361 {
  given Ordering[Data361] = Ordering.by(_.id)
  def empty: Data361 = Data361(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data361 =
    Data361(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data361] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
