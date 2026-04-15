package generated

final case class Data1255(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1255 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1255 = copy(value = value * k)
  def addTag(t: String): Data1255 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1255 = copy(meta = meta.updated(k, v))
  def merge(other: Data1255): Data1255 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1255 {
  given Ordering[Data1255] = Ordering.by(_.id)
  def empty: Data1255 = Data1255(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1255 =
    Data1255(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1255] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
