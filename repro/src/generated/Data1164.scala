package generated

final case class Data1164(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1164 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1164 = copy(value = value * k)
  def addTag(t: String): Data1164 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1164 = copy(meta = meta.updated(k, v))
  def merge(other: Data1164): Data1164 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1164 {
  given Ordering[Data1164] = Ordering.by(_.id)
  def empty: Data1164 = Data1164(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1164 =
    Data1164(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1164] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
