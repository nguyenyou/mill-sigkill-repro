package generated

final case class Data1094(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1094 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1094 = copy(value = value * k)
  def addTag(t: String): Data1094 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1094 = copy(meta = meta.updated(k, v))
  def merge(other: Data1094): Data1094 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1094 {
  given Ordering[Data1094] = Ordering.by(_.id)
  def empty: Data1094 = Data1094(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1094 =
    Data1094(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1094] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
