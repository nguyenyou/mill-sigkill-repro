package generated

final case class Data735(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data735 = copy(name = name.toUpperCase)
  def scale(k: Double): Data735 = copy(value = value * k)
  def addTag(t: String): Data735 = copy(tags = t :: tags)
  def put(k: String, v: String): Data735 = copy(meta = meta.updated(k, v))
  def merge(other: Data735): Data735 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data735 {
  given Ordering[Data735] = Ordering.by(_.id)
  def empty: Data735 = Data735(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data735 =
    Data735(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data735] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
