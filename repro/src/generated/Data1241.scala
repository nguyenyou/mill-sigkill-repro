package generated

final case class Data1241(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1241 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1241 = copy(value = value * k)
  def addTag(t: String): Data1241 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1241 = copy(meta = meta.updated(k, v))
  def merge(other: Data1241): Data1241 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1241 {
  given Ordering[Data1241] = Ordering.by(_.id)
  def empty: Data1241 = Data1241(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1241 =
    Data1241(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1241] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
