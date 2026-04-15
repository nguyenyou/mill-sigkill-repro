package generated

final case class Data753(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data753 = copy(name = name.toUpperCase)
  def scale(k: Double): Data753 = copy(value = value * k)
  def addTag(t: String): Data753 = copy(tags = t :: tags)
  def put(k: String, v: String): Data753 = copy(meta = meta.updated(k, v))
  def merge(other: Data753): Data753 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data753 {
  given Ordering[Data753] = Ordering.by(_.id)
  def empty: Data753 = Data753(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data753 =
    Data753(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data753] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
