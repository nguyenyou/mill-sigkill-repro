package generated

final case class Data997(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data997 = copy(name = name.toUpperCase)
  def scale(k: Double): Data997 = copy(value = value * k)
  def addTag(t: String): Data997 = copy(tags = t :: tags)
  def put(k: String, v: String): Data997 = copy(meta = meta.updated(k, v))
  def merge(other: Data997): Data997 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data997 {
  given Ordering[Data997] = Ordering.by(_.id)
  def empty: Data997 = Data997(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data997 =
    Data997(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data997] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
