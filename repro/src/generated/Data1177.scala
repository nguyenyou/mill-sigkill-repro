package generated

final case class Data1177(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1177 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1177 = copy(value = value * k)
  def addTag(t: String): Data1177 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1177 = copy(meta = meta.updated(k, v))
  def merge(other: Data1177): Data1177 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1177 {
  given Ordering[Data1177] = Ordering.by(_.id)
  def empty: Data1177 = Data1177(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1177 =
    Data1177(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1177] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
