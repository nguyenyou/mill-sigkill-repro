package generated

final case class Data9(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data9 = copy(name = name.toUpperCase)
  def scale(k: Double): Data9 = copy(value = value * k)
  def addTag(t: String): Data9 = copy(tags = t :: tags)
  def put(k: String, v: String): Data9 = copy(meta = meta.updated(k, v))
  def merge(other: Data9): Data9 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data9 {
  given Ordering[Data9] = Ordering.by(_.id)
  def empty: Data9 = Data9(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data9 =
    Data9(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data9] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
